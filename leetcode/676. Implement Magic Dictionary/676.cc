class MagicDictionary
{
private:
    class TrieTree
    {
        bool is_word;
        TrieTree *nxt[26];
        TrieTree()
        {
            is_word = false;
            memset(nxt, 0, sizeof(nxt));
        }
        ~TrieTree(){
            for (size_t i = 0; i < sizeof(nxt)/sizeof(nxt[0]); i++)
            {
                if(nxt[i] == nullptr) return;
                else
                {
                    
                    free(nxt[i]);
                    nxt[i]=NUll;
                }
                
            }
            
        }
    };
    TrieTree * root;
public:
    /** Initialize your data structure here. */
    MagicDictionary()
    {
        root = new TrieTree();
    }

    /** Build a dictionary through a list of words */
    void buildDict(vector<string> dict)
    {
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    bool search(string word)
    {
    }
};

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary* obj = new MagicDictionary();
 * obj->buildDict(dict);
 * bool param_2 = obj->search(word);
 */

class MagicDictionary
{
public:
    /** Initialize your data structure here. */
    struct TreeNode
    {
        bool isword;
        TreeNode *child[26];
        TreeNode()
        {
            isword = false;
            memset(child, NULL, sizeof(child));
        }
    };
    TreeNode *root;
    MagicDictionary() { root = new TreeNode(); }

    /** Build a dictionary through a list of words */
    void buildDict(vector<string> dict)
    {
        for (int i = 0; i < dict.size(); i++)
        {
            TreeNode *p = root;
            for (int j = 0; j < dict[i].size(); j++)
            {
                int ch1 = dict[i][j] - 'a';
                if (!p->child[ch1])
                    p->child[ch1] = new TreeNode();
                p = p->child[ch1];
            }
            p->isword = true;
        }
    }
    bool helper(string word, bool &flag, int level, TreeNode *p) //flag???????????????????????????????????????
    {
        int ch1 = word[level] - 'a';
        if (level == word.size() - 1) //???????????????????????????
        {
            if (flag == false)
            { //????????????????????????????????????child[ch1]????????????hello????????????????????????????????????false????????????????????????
                for (int i = 0; i < 26; i++)
                {
                    if (i != ch1 && p->child[i] && p->child[i]->isword)
                        return true;
                }
                return false;
            }
            else
            { //???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
                if (p->child[ch1] && p->child[ch1]->isword)
                    return true;
                else
                    return false;
            }
        }
        else //???????????????????????????????????????
        {
            if (flag == false) //?????????????????????
            {                  //???????????????????????????
                for (int i = 0; i < 26; i++)
                {
                    if (i != ch1 && p->child[i])
                    {
                        flag = true;
                        if (helper(word, flag, level + 1, p->child[i]))
                            return true;
                        //???????????????????????????????????????25???child????????????????????????????????????????????????,?????????????????????????????????????????????flag?????????false
                        flag = false;
                    }
                }
            }
            //?????????????????????????????????else????????????????????????????????????????????????if?????????????????????25???child??????????????????????????????????????????????????????????????????????????????
            if (p->child[ch1])
                return helper(word, flag, level + 1, p->child[ch1]);
            else
                return false;
        }
        return false;
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    bool search(string word)
    {
        bool flag = false;
        return helper(word, flag, 0, root);
    }
};
