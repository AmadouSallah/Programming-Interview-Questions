# 1) Let us improve our bubble sort by using a boolean 'swapped' that we initially set to true.
# 2) In our 1st inner loop, we iterate as long as swapped is true and the index i is less than the input array's length.
# i) We set swapped to false.
# ii) We start an inner loop whose index j starts at 0, and we iterate all the way to the end of the input array
# a) If we find an element array[j] that is greater than the element that follows it, we swap the 2 elements and set 'swapped' to true.
# b) If at the end of any of the inner loops we didn't get to swap elements, the outer loop ends (since swapped is false).
# 3) We return array at the end

def bubble_sort_improved(array)
  len = array.length
  swapped = true
  i = 0
  while i < len && swapped
    swapped = false
    j = 0
    while j < len-1
      if array[j] > array[j+1]
        swap(array, j, j+1)
        swapped = true
      end
      j += 1
    end
    i += 1
  end
  array
end

def swap(array, index1, index2)
  temp = array[index1]
  array[index1] = array[index2]
  array[index2] = temp
end

# Best case time complexity = 0(n)
# Worst case time complexity = 0(n^2)
# For regular bubble sort, both best and worst case time complexities are 0(n^2)

# TEST DRIVE
my_array = [5, 1, -1, 0, 8, 5]

p bubble_sort_improved([]) == []
p bubble_sort_improved([3]) == [3]
p bubble_sort_improved([30, 3]) == [3, 30]
p bubble_sort_improved(my_array) == [-1, 0, 1, 5, 5, 8]
p bubble_sort_improved([-1,1,3,1,4, 3, 1]) == [-1, 1, 1, 1, 3, 3, 4]