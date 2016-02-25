=begin

Given a 2D array, print it in spiral form.
Example:
Input:
        1    2   3
        4    5   6
        7    8   9

Output: 1 2 3 6 9 8 7 4 5

Input:
        1   2   3   4  5   6
        7   8   9  10  11  12
        13  14  15 16  17  18

Output: 1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11

=end

def print_2d_array_in_spiral(matrix)
  first_row, last_row = 0, matrix.length
  first_column, last_column = 0, matrix[0].length

  while (first_row < last_row && first_column < last_column)

    # Printing the top row of the remaining rows
    col = first_column
    while col < last_column
      print matrix[first_row][col], " "
      col += 1
    end
    first_row += 1 # first row moves to the next matrix row

    # Printing the right column of the remaining columns
    row = first_row
    while row < last_row
      print matrix[row][last_column-1], " "
      row += 1
    end
    last_column -= 1 # last column moves to the left by 1

    # Printing the bottom row of the remaining rows
    if last_row > first_row
      col = last_column-1
      while col >= first_column
        print matrix[last_row-1][col], " "
        col -= 1
      end
      last_row -= 1 # the last row moves up by 1
    end

    # Printin the left column of the remaining columns
     if last_column > first_column
      row = last_row-1
      while row >= first_row
        print matrix[row][first_column], " "
        row -= 1
      end
      first_column += 1 # first column moves to the right by 1
    end

  end
  puts
end

matrix1 = [[1,2,3], [4,5,6], [7,8,9]]
matrix2 = [[1,2,3,4,5,6], [7,8,9,10,11,12], [13,14,15,16,17,18]]

print_2d_array_in_spiral(matrix1)
print_2d_array_in_spiral(matrix2)