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

# SOLUTION 2
# PSEUDOCODE:
# In a 2-dimension matrix, for every (x, y) point, the corresponding rotated point (x', y') = (x*cos(0)-y*sin(0), x*sin(0) + y*cos(0)) where 0 is the angle between the point and the x-axis.
# For a rotation of 0 = 90, (x', y') = (-y, x). Therefore matrix[row][column] becomes matrix[matrix.length - column - 1]
# We apply this formula to get the rotated matrix

def rotate_2(matrix)
  len = matrix.length
  return matrix if len < 1
  rotated_matrix = Array.new(matrix[0].length) {Array.new(len)}
  matrix.each_with_index do |row, row_index|
    row.each_with_index do |col, col_index|
      rotated_matrix[row_index][col_index] = matrix[len - col_index - 1][row_index]
    end
  end
  rotated_matrix
end

# SOLUTION 3
# PSEUDOCODE
# We rotate the matrix by layers starting from the outer layer all the way to layer len / 2 where len is the length of the input matrix
# len/2 since each layer covers 2 rows and 2 colums. Example the first layer (outer layer) is row 0 (top row), column len-1 (last column), row len-1 (last row), and column 0 (first column).
# For each layer, we rotate all the elements clockwise

def rotate_3(matrix)
  len = matrix.length
  layer = 0
  while layer < len / 2
    first_column_layer = layer
    last_column_layer = len - layer - 1

    # Iterate from first_column_layer to last_column_layer
    col = first_column_layer
    while col < last_column_layer
      offset = col - first_column_layer
      top = matrix[first_column_layer][col]
      # move the value from bottom left to top
      matrix[first_column_layer][col] = matrix[last_column_layer - offset][first_column_layer]
      #
      matrix[last_column_layer - offset][first_column_layer] = matrix[last_column_layer][last_column_layer - offset]

      matrix[last_column_layer][last_column_layer - offset] = matrix[col][last_column_layer]

      matrix[col][last_column_layer] = top

      col += 1
    end
    layer += 1
  end
  matrix
end

# TEST DRIVE
matrix = [[1, 2, 3, 4], [5, 6, 7, 8],[9, 0, 1, 2],[3, 4, 5, 6]]

p rotate([]) == []
p rotate([[1]]) == [[1]]
p rotate([[1, 2], [3, 4]]) == [[3, 1], [4, 2]]
p rotate([[1, 2]]) == [[1], [2]]
p rotate(matrix) == [[3, 9, 5, 1], [4, 0, 6, 2], [5, 1, 7, 3], [6, 2, 8, 4]]

p rotate_2([]) == []
p rotate_2([[1]]) == [[1]]
p rotate_2([[1, 2], [3, 4]]) == [[3, 1], [4, 2]]
p rotate_2(matrix) == [[3, 9, 5, 1], [4, 0, 6, 2], [5, 1, 7, 3], [6, 2, 8, 4]]

p rotate_3([]) == []
p rotate_3([[1]]) == [[1]]
p rotate_3([[1, 2], [3, 4]]) == [[3, 1], [4, 2]]
p rotate_3(matrix) == [[3, 9, 5, 1], [4, 0, 6, 2], [5, 1, 7, 3], [6, 2, 8, 4]]