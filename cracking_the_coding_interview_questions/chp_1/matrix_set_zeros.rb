# Problem 1.7
#1.7 Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0
# Example:
# 1 0 1 1 0
# 0 1 1 1 0
# 1 1 1 1 1
# 1 0 1 1 1
# 1 1 1 1 1
# would results into:
# 0 0 0 0 0
# 0 0 0 0 0
# 0 0 1 1 0
# 0 0 0 0 0
# 0 0 1 1 0

# PSEUDOCODE
# 1) We need to track the row/col that has a zero in it. For that, we initialize 2 arrays (rows_array and columns_array) each containing initially only 0s.
# If a row (resp. column) contains a 0, we set rows_array[row] (resp. columns_array[column]) to 0.
# 2) We loop through rows_array (resp. columns_array) and whenever we encounter a 0, we delete the whole row (resp. column) from the matrix by calling the function nullify_row (resp. nullify_column) - See (3) for these 2 functions
# 3) We define 2 functions, nullify_row and nullify_column, each taking as arguments the matrix and the row (resp. column) to delete from the matrix.
#  nullify_row (resp. nullify_column) will set all the matrix elements of the row (resp. column) to zero.

def set_zeros(matrix)
  rows_array = Array.new(matrix.length) {0}
  columns_array = Array.new(matrix[0].length) {0}

  matrix.each_with_index do |row, row_index|
    row.each_with_index do |cell, col_index|
      if cell == 0
        rows_array[row_index] = 1
        columns_array[col_index] = 1
      end
    end
  end

  rows_array.each_with_index {|element, row| nullify_row(matrix, row) if element == 1 }

  columns_array.each_with_index {|element, col| nullify_column(matrix, col) if element == 1}

  matrix
end

def nullify_row(matrix, row)
  col = 0
  while col < matrix[0].length
    matrix[row][col] = 0
    col += 1
  end
end

def nullify_column(matrix, col)
  row = 0
  while row < matrix.length
    matrix[row][col] = 0
    row += 1
  end
end

# TEST DRIVE

matrix = [[1, 0, 1, 1, 0], [0, 1, 1, 1, 0], [1, 1, 1, 1, 1], [1, 0, 1, 1, 1], [1, 1, 1, 1, 1]]

 p set_zeros(matrix) == [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 1, 0], [0, 0, 0, 0, 0], [0, 0, 1, 1, 0]]
 p set_zeros([[1,0,3], [4,5,6]]) == [[0, 0, 0], [4, 0, 6]]