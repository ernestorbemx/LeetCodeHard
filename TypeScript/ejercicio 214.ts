function shortestPalindrome(s: string): string {
    for (let r = s.length - 1; r >= 0; r--) {
        if (isPali(s, 0, r)) {
            return s.slice(r + 1).split('').reverse().join('') + s;
        }
    }
    return "";
};

function isPali(s: string, l: number, r: number): boolean {
    while (l <= r) {
        if (s[l] !== s[r]) {
            return false;
        }
        l++;
        r--;
    }
    return true;
}

const s = "abca";
console.log(shortestPalindrome(s));
