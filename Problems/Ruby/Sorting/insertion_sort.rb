# PSEUDOCODE
# A) We iterate through the input array from index i = 1 to the end of the array.
# B) For each i, we do the followings:
# 1) We save the element at position i in a variable we will call 'key'
# 2) Starting from position j = i-1, we iterate backward (going left) upto and including 0; we iterate as long as j >= 0 and array[j] > key.
# Our objective here is to locate the smallest index j for which array[j] > array[i] (the key).
# 3) In each iteration, we shift the array element up one position
# C) At the end of the inner iteration, we copy the key into array[j+1]

def insertion_sort(array)
  i = 1
  while i < array.length
    key = array[i]
    j = i - 1
    # insert key into the sorted left side
    while j >= 0 && array[j] > key
      array[j+1] = array[j]
      j -= 1
    end
    array[j+1] = key
    i += 1
  end
  array
end

# TEST DRIVE
my_array = [28, 4, -2, 1, 0, 5, 3]

p insertion_sort([]) == []
p insertion_sort([3]) == [3]
p insertion_sort([4, -3]) == [-3, 4]
p insertion_sort(my_array) == [-2, 0, 1, 3, 4, 5, 28]