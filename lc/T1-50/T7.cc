class Solution
{
public:
    int reverse(int x)
    {
        string s = to_string(x);
        x < 0 ? (::reverse(s.begin() + 1, s.end())) : (::reverse(s.begin(), s.end()));
        long k = stol(s);
        return k < INT_MIN || k > INT_MAX ? 0 : static_cast<int>(k);
    }
}; 