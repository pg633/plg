class Solution {
public:
    string nearestPalindromic(string n) {
        size_t sz;
        uint64_t  k = stoll(n, &sz, 10);
        int  len = n.size();

        if (n.size() == 1) 
        { 
            string s = to_string(k-1);
            return  s;
        }
        

        int centerPos = (len - 1) / 2;

        int arrayS[len+1];
        int arraySs[len+1];

        int lenss = len;
        int lens = len;

        int i  = 0;
        uint64_t ok = k;
        pr(ok, k);
        for (int i = 0; i < len; i++) {
            arraySs[i] = arrayS[i] = n[i] - '0';
        }

        // generate correct arrayS;
        for (int i = 0; i <= centerPos; i++) {
            arrayS[len - 1 - i] = arrayS[i];
            arraySs[len - 1 - i] = arraySs[i];
        }

        uint64_t v1 = GetNumberFromArray(arraySs, lenss);
        pr(v1, k);

        if (v1 == ok) {
            // change arrayS less
            DecreaseArray(arraySs, lenss, centerPos); 
            // change ArraySs bigger
            IncreaseArray(arrayS, lens, centerPos); 
        }
        else if (v1 > ok) {
            // change arrayS less
            DecreaseArray(arraySs, lenss, centerPos);
        }
        else {
            // change arrayS bigger
            IncreaseArray(arrayS, lens, centerPos);
        }

        v1 = GetNumberFromArray(arraySs, lenss);
        // reduce arrays
        uint64_t v2 = GetNumberFromArray(arrayS, lens);
        pr(v1,ok);
        pr(v2,ok);
        int64_t v11 = v1 - ok;
        int64_t v22 = v2 - ok;
        
        v11 = v11 > 0 ? v11 : v11 * -1;
        v22 = v22 > 0 ? v22 : v22 * -1;

        if (v22 >= v11) 
            return GenerateNumStr(arraySs, lenss) ;
        else
            return GenerateNumStr(arrayS, lens);
    }

    void IncreaseArray(int array[] , int &len, int c)
    {
        int isAll9 = true;
        for (int i = 0; i < len; i++) {
            if (array[i] != 9) {
                isAll9 = false;
                break;
            }
        }

        if (isAll9 == false) {
            int cp = c;
            while (cp >= 0) {
                if (array[cp] == 9) {
                    array[cp] = 0;
                    cp = cp - 1;
                } else {
                    array[cp]++;
                    break;
                }
            }

            // regenerate array
            for (int i = 0; i <= c; i++) 
                array[len - 1 - i] = array[i];

        }
        else {
            len++;
            for (int i = 0; i < len; i++) {
                array[i] = 0;
            }
            array[0] = array[len-1] = 1;
        }

    }

    void DecreaseArray(int array[] , int &len, int c)
    {
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = sum + array[i]; 
        } 
        if (sum == 2) {
            len--;
            for (int i = 0; i < len; i++)
                array[i] = 9;
            return;
        }

        int cp = c;
        while (cp >= 0) {
            if (array[cp] == 0) {
                array[cp] = 9;
                cp = cp - 1;
            } else {
                array[cp]--;
                break;
            }
        }
        for (int i = 0; i <= c; i++) 
            array[len - 1 - i] = array[i];
    }



    uint64_t GetNumberFromArray(int array[], int len) {
        uint64_t v = 0;
        for (int i = 0; i < len; i++)
        {
            v += array[i];
            v = v * 10;
        }
        return v / 10;
    }

    string GenerateNumStr(int array[], int len) {
        string s(len, '0');

        for (int i = 0; i < len; i++) {
                pr(i, array[i]);
                s[i] = '0' + array[i];
        }

        return s;
    }

};