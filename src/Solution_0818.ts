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

/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {boolean}
 */
var hasCycle = function (head) {
    const set = new Set();
    while (head !== null) {
        const prevSize = set.size;
        set.add(head);
        const curSize = set.size;
        if (curSize === prevSize) {
            return true;
        }
        head = head.next;
    }
    return false;
};

function lengthOfLongestSubstring(s: string): number {
    const len = s.length;
    if(len === 0){
        return 0;
    }
    const dp:number[] = [];
    dp[0] = 1;
    let max: number = 1;
    for(let i  = 1; i < len; i++){
        dp[i] = 1;
        for(let j = 0; j < i; j++){
            if(s.substring(j, i).indexOf(s[i]) === -1){
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        max = Math.max(max, dp[i]);
    }
    return max;
};
