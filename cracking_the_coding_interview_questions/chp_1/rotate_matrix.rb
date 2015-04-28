# Problem 1.6
# Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
# write a method to rotate the image by 90 degrees. Can you do this in place?

# [1][2][3][4]             [3][9][5][1]
# [5][6][7][8]  BECOMES    [4][0][6][2]
# [9][0][1][2]             [5][1][7][3]
# [3][4][5][6]             [6][2][8][4]

# SOLUTION 1
# PSEUDOCODE:
# We create an empty array, rotated_by_90, that will contain the result of rotating the input matrix by 90 degrees
# We transpose the input matrix, and for each row of the transposed matrix, we reverse it and append it to rotated_by_90
# We return rotated_by_90

def rotate(matrix)
  rotated_by_90 = []
  matrix.transpose.each {|row| rotated_by_90 << row.reverse}
  rotated_by_90
end

array = [[1, 2, 3, 4], [5, 6, 7, 8],[9, 0, 1, 2],[3, 4, 5, 6]]

p rotate([]) == []
p rotate([[1]]) == [[1]]
p rotate([[1, 2]]) == [[1], [2]]
p rotate(array) == [[3, 9, 5, 1], [4, 0, 6, 2], [5, 1, 7, 3], [6, 2, 8, 4]]