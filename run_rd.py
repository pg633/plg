import requests
import os
import json
import time
import shutil

class Config:
    local_path = os.getcwd()
    github_leetcode_url = 'https://github.com/pg633/plg/master/leetcode/'
    leetcode_url = 'https://leetcode.com/problems/'
    oj = 'leetcode'

class Question:

    def __init__(self, id_,
                 name, url,
                 lock, difficulty):
        self.id_ = id_
        self.title = name
        # the problem description url　问题描述页
        self.url = url
        self.lock = lock  
        # boolean，锁住了表示需要购买
        self.difficulty = difficulty
        # the solution url
        self.python = ''
        self.java = ''
        self.go = ''
        self.c_plus_plus = ''

    def __repr__(self):
        """
        :return:
        """
        return str(self.id_) + ' ' + str(self.title) + ' ' + str(self.url)


class TableInform:
    def __init__(self):
        # raw questions inform
        self.questions = []
        # this is table index
        self.table = []
        # this is the element of question
        self.table_item = {}
        self.locked = 0

    def get_leetcode_problems(self):
        """
        used to get leetcode inform
        :return:
        """
        # we should look the response data carefully to find law
        # return byte. content type is byte
        content = requests.get('https://leetcode.com/api/problems/algorithms/').content
        # get all problems
        self.questions = json.loads(content)['stat_status_pairs']
        # print(self.questions)
        difficultys = ['Easy', 'Medium', 'Hard']
        for i in range(len(self.questions) - 1, -1, -1):
            question = self.questions[i]
            name = question['stat']['question__title']
            url = question['stat']['question__title_slug']
            id_ = str(question['stat']['frontend_question_id'])
            if int(id_) < 10:
                id_ = '00' + id_
            elif int(id_) < 100:
                id_ = '0' + id_
            lock = question['paid_only']
            if lock:
                self.locked += 1
            difficulty = difficultys[question['difficulty']['level'] - 1]
            url = Config.leetcode_url + url + '/description/'
            q = Question(id_, name, url, lock, difficulty)
            self.table.append(q.id_)
            self.table_item[q.id_] = q
        return self.table, self.table_item

    # create problems folders
    def __create_folder(self, oj_name):
        oj_algorithms = Config.local_path + '/' + oj_name
        if os.path.exists(oj_algorithms):
            print(oj_name, ' algorithms is already exits')
        else:
            print('creating {} algorithms....'.format(oj_name))
            os.mkdir(oj_algorithms)
        for item in self.table_item.values():
            question_folder_name = oj_algorithms + '/' + item.id_ + '. ' + item.title
            if not os.path.exists(question_folder_name):
                print(question_folder_name + 'is not exits, create it now....')
                os.mkdir(question_folder_name)
            # try:
            #     import shutil
            #     ff = map[int(item.id_)]
            #     if len(ff) > 0:
            #         shutil.copy(ff, question_folder_name + '/' + item.id_ + '.' + ff.split('.')[1])
            # except Exception as  e:
            #     print(item.id_)

    def update_table(self, oj):
        # the complete inform should be update
        complete_info = CompleteInform()
        self.get_leetcode_problems()
        # the total problem nums
        complete_info.total = len(self.table)
        complete_info.lock = self.locked
        self.__create_folder(oj)
        oj_algorithms = Config.local_path + '/' + oj
        # 查看os.walk看具体返回的是什么东西
        for _, folders, _ in os.walk(oj_algorithms):
            for folder in folders:
                for _, _, files in os.walk(os.path.join(oj_algorithms, folder)):
                    # print(files)
                    if len(files) != 0:
                        complete_info.complete_num += 1
                    for item in files:
                        if item.endswith('.py'):
                            complete_info.solved['python'] += 1
                            folder_url = folder.replace(' ', "%20")
                            folder_url = os.path.join(folder_url, item)
                            folder_url = os.path.join(Config.github_leetcode_url, folder_url)
                            self.table_item[folder[:3]].python = '[Python]({})'.format(folder_url)
                        elif item.endswith('.java'):
                            complete_info.solved['java'] += 1
                            folder_url = folder.replace(' ', "%20")
                            folder_url = os.path.join(folder_url, item)
                            folder_url = os.path.join(Config.github_leetcode_url, folder_url)
                            self.table_item[folder[:3]].java = '[Java]({})'.format(folder_url)
                        elif item.endswith('.cpp') or item.endswith('.cc'):
                            complete_info.solved['c++'] += 1
                            folder_url = folder.replace(' ', "%20")
                            folder_url = os.path.join(folder_url, item)
                            folder_url = os.path.join(Config.github_leetcode_url, folder_url)
                            self.table_item[folder[:3]].c_plus_plus = '[C++]({})'.format(folder_url)
                        elif item.endswith('.go'):
                            complete_info.solved['go'] += 1
                            folder_url = folder.replace(' ', "%20")
                            folder_url = os.path.join(folder_url, item)
                            folder_url = os.path.join(Config.github_leetcode_url, folder_url)
                            self.table_item[folder[:3]].go = '[go]({})'.format(folder_url)
        readme = Readme(complete_info.total, complete_info.complete_num, complete_info.lock, complete_info.solved)
        readme.create_leetcode_readme([self.table, self.table_item])
        print('-------the complete inform-------')
        print(complete_info.solved)


class CompleteInform:
    """
    this is statistic inform
    """

    def __init__(self):
        self.solved = {
            'python': 0,
            'c++': 0,
            'java': 0,
            'go': 0
        }
        self.complete_num = 0
        self.lock = 0
        self.total = 0

    def __repr__(self):
        return str(self.solved)


class Readme:
    """
    generate folder and markdown file
    update README.md when you finish one problem by some language
    """

    def __init__(self, total, solved, locked, others):
        """
        :param total: total problems nums
        :param solved: solved problem nums
        :param others: 暂时还没用，我想做扩展
        """
        self.total = total
        self.solved = solved
        self.others = others
        self.locked = locked
        self.time = time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())
        self.msg = '# Keep thinking, keep alive\n' \
                   'Until {}, I have solved **{}** / **{}** problems ' \
                   'while **{}** are still locked.' \
                   '\n\nCompletion statistic: ' \
                   '\n1. go: {go} ' \
                   '\n2. Python: {python}' \
                   '\n3. C++: {c++}' \
                   '\n4. Java: {java}' \
                   '\n\nNote: :lock: means you need to buy a book from LeetCode\n'.format(
            self.time, self.solved, self.total, self.locked, **self.others)

    def create_leetcode_readme(self, table_instance):
        """
        create REAdME.md
        :return:
        """
        file_path = Config.local_path + '/README.md'
        # write some basic inform about leetcode
        with open(file_path, 'w') as f:
            f.write(self.msg)
            f.write('\n----------------\n')

        with open(file_path, 'a') as f:
            f.write('## LeetCode Solution Table\n')
            f.write('| ID | Title | Difficulty | go | Python | C++ | Java |\n')
            f.write('|:---:' * 7 + '|\n')
            table, table_item = table_instance
            for index in table:
                item = table_item[index]
                if item.lock:
                    _lock = ':lock:'
                else:
                    _lock = ''
                data = {
                    'id': item.id_,
                    'title': '[{}]({}) {}'.format(item.title, item.url, _lock),
                    'difficulty': item.difficulty,
                    'js': item.go if item.go else 'To Do',
                    'python': item.python if item.python else 'To Do',
                    'c++': item.c_plus_plus if item.c_plus_plus else 'To Do',
                    'java': item.java if item.java else 'To Do'
                }
                line = '|{id}|{title}|{difficulty}|{js}|{python}|{c++}|{java}|\n'.format(**data)
                f.write(line)
            print('README.md was created.....')


def main():
    table = TableInform()
    table.update_table(Config.oj)
    

if __name__ == '__main__':
    main()


# map = {}
# def walkFile(file):
#     for root, dirs, files in os.walk(file, topdown=True):
#         for f in files:
#             fileDir = os.path.join(root, f)
#
#             import re
#             s = re.findall("[tT][_]?(\d+)", f)
#             if len(s) >= 1:
#                 map[int(s[0])] = os.path.join(root, f)
