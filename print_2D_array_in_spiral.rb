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

##################### 2nd SOLUTION ##########################

def print_2d_array_in_spiral_2(matrix)
    top_row, bottom_row = 0, matrix.length-1
    left_column, right_column = 0, matrix[0].length-1
    direction = 0
    # if direction = 0, we print the top row from left to right,
    # if direction = 1, we print the right column from top to bottom,
    # if direction = 2, we print the bottom row from right to left
    # if direction = 3, we print the left column from bottom to top

    while (top_row <= bottom_row && left_column <= right_column)

      case direction

        when 0 # Print the top row
          col = left_column
          while col <= right_column
            print matrix[top_row][col], " "
            col += 1
          end
          top_row += 1 # moving the top row down by 1

        when 1 # Print the right column
          row = top_row
          while row <= bottom_row
            print matrix[row][right_column], " "
            row += 1
          end
          right_column -= 1 # Decrementing the right column by 1

        when 2  # Print the bottow row
          col = right_column
          while col >= left_column
            print matrix[bottom_row][col], " "
            col -= 1
          end
          bottom_row -= 1 # Moving the bottom_row up by 1

        when 3  # Print the left column
          row = bottom_row
          while row >= top_row
            print matrix[row][left_column], " "
            row -= 1
          end
          left_column += 1 # Moving the left column to the right by 1

      end # end of case

      direction = (direction + 1) % 4
    end # end of outer while loop
    puts
end

######## TEST CASES ########

matrix1 = [[1,2,3], [4,5,6], [7,8,9]]
matrix2 = [[1,2,3,4,5,6], [7,8,9,10,11,12], [13,14,15,16,17,18]]

print_2d_array_in_spiral(matrix1)
print_2d_array_in_spiral(matrix2)

print_2d_array_in_spiral_2(matrix1)
print_2d_array_in_spiral_2(matrix2)