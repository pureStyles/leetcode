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
