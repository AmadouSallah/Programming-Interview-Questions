/*
Problem 31. Next Permutation

Implement next permutation, which rearranges numbers into the lexicographically next
greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible
order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its
corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

*/

/*
We will be using the following 4 steps from Wikipedia https://en.wikipedia.org/wiki/Permutation

1. Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
2. Find the largest index l greater than k such that a[k] < a[l].
3. Swap the value of a[k] with that of a[l].
4. Reverse the sequence from a[k + 1] up to and including the final element a[n].

    PSEUDOCODE

1) Starting from the right (last element of nums), we find the the largest index k such that nums[k] < nums[k + 1]
(i.e. the 1st consecutive pair such that nums[k] < nums[k + 1])
Note that for any decreasing sequence, no next permutation is possible. Example [3, 2, 1] has no next permutation.
So if k = -1 at the end of this step, i.e. all the elements of nums satisty nums[k] < nums[k + 1], we are done.

2) We find the largest index l  greater than k (l > k) such that nums[k] < nums[l]. (so we start l at the last
element and decrement it until we find a number > nums[k])

3) We swap nums[k] with that of nums[l].

4) We then reverse nums from k+1 to the end in order to get the next smallest lexicographic permutation.

Why do we reverse?

After swapping nums[k] with a larger value, i.e. nums[l], the current sequence is larger than the previous one and any
permutation of the elements to the right of nums[k] will still make it larger than the initial sequence.
However, since we want the 'next' permutation, meaning the smallest one, we need to pick the smallest sequence
to the right of nums[k]. But remember that the elements to the right of nums[k] form a decreasing sequence.
So in order to get the smallest sequence, we need to reverse it (to become increasing) in order to get
the smallest permutation. Say for example the elements to the right are [3,2,1], which is decreasing;
the smallest we can get from this is by reversing to get [1,2,3] (increasing now).

Example, assume nums = [2, 4, 5, 7, 6, 3, 1] and we want to find the next permutation
a) Using step 1, starting at the last element, we find the index k such that nums[k] < nums[k + 1].
    k will be 2 since nums[2] = 5, nums[3] = 7, and 5 < 7.
b) Step 2: We find the largest index l (l > k) such that nums[k] < nums[l], i.e nums[2] < nums[l]. Since
    nums[2] = 5, starting from the right (1, 3, 6, 7), we see that nums[l] = 6, i.e l = 4
c) Now we swap nums[k] and nums[l]. (k = 2, and l = 4). Therefore, after swapping, nums becomes:
    nums = [2, 4, 6, 7, 5, 3, 1]
d) Now we reverse the elements to the right of nums[k] = nums[2] = 6. But before we do that, let's explain one
    more time why we need to reverse:
    We can see that elements to the right of nums[k] form a decreasing sequence [7, 5, 3, 1]. In order to get the
    smallest next permutation, we just need to reverse it to get an increasing sequence [1, 3, 5, 7]; any other
    permutation will be larger than this increasing subsequence.

    After reversing, nums becomes [2, 4, 6, 1, 3, 5, 7] and this is our answer.
*/
