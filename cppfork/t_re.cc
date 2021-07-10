#include <bits/stdc++.h>
#include <boost/regex.hpp>
using namespace std;

int main()
{
    // string pattern("[^c]ei");
    // pattern = "[[:alpha:]]*" + pattern + "[[:alpha:]]*";
    // regex r(pattern);
    // smatch ret;
    // string reg_test = "receipt freind theif receive";
    // if (regex_search(reg_test, ret, r))
    //     cout << "find the str: " << ret.str() << endl;

    //使用regex_iterator,输出所有的匹配结果,并且输出上下文
    // string pattern1("[^c]ei");
    // pattern1 = "[[:alpha:]]*" + pattern1 + "[[:alpha:]]*";
    // regex r2(pattern1, regex::icase);
    // string reg_test = "receipt freind theif receive";
    // for (sregex_iterator it(reg_test.begin(), reg_test.end(), r2), end_it; it != end_it; ++it)
    // {
    //     auto pos = it->prefix().length();
    //     pos = pos > 40 ? pos - 40 : 0;
    //     cout << it->prefix().str().substr(pos)
    //          << "\n\t\t>>>" << it->str() << "<<<\n"
    //          << it->suffix().str().substr(0, 40) << endl;
    // }

    // string reg_phone = "(\\()?(\\d{3})(\\))?([-. ])?(\\d{3})([-. ]?)(\\d{4})";
    // string reg_replace_test = "(654) 123-7856";
    // regex reg_replace(reg_phone);
    // string regex_replace_fmt = "$2-$5-$7";
    // cout << regex_replace(reg_replace_test, reg_replace, regex_replace_fmt) << endl;




    //问号(?)表示之前的可以选择  
    // std::string phone =  
    //         "(\\()?(\\d{3})(\\))?([-. ])?(\\d{3})([-. ]?)(\\d{4})";  
    // boost::regex r(phone);  
    // //代替  
    // std::string fmt("$2.$5.$7");  
    // std::string number("(908)555-1800");  
    // std::cout << regex_replace(number, r, fmt) << std::endl;  
  
    // std::string file("Caroline (201)555-2368 862-55-0123");  
    // std::cout << boost::regex_replace(file, r, fmt) << std::endl;  
    // std::cout << boost::regex_replace(file, r, fmt,  
    //         boost::regex_constants::format_no_copy) << std::endl;  




}