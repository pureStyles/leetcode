/**
 *
 * @param {String} s
 * @return {number}
 */
var lengthOfLongestSubString = function(s){
    const len = s.length;
    let start = 0, end = 0, res = 0;
    const set =  new Set();
    while(end < len){
        while(end < len && !set.has(s[end])){
            set.add(s[end]);
            end ++;
            res = Math.max(res, end - start);
        }
        // set里已经有这个值；
        set.delete(s[start]);
        start ++;
    }
    return res;
}

const s = lengthOfLongestSubString("pwwkew");
console.log(s);
