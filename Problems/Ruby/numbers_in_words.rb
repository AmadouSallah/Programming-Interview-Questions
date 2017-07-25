# Problem: Write a program to convert a given number into words (eg 123 as input should output one one hundred and twenty three)

NUMBER_WORDS = {0 => '', 1 => 'one', 2 => 'two', 3 => 'three', 4 => 'four', 5 => 'five', 6 => 'six', 7 => 'seven', 8 => 'eight', 9 => 'nine', 10 => 'ten', 11 => 'eleven', 12 => 'twelve', 13 => 'thirtheen', 14 => 'fourteen', 15 => 'fifteen', 16 => 'sixteen', 17 => 'seventeen', 18 => 'eighteen', 19 => 'nineteen', 20 => 'twenty', 30 => 'thirty', 40 => 'fourty', 50 => 'fifty', 60 => 'sixty', 70 => 'seventy', 80 => 'eighty', 90 => 'ninety'}

POWERS_OF_TEN = {12 => 'trillion', 9 => 'billion', 6 => 'million', 3 => 'thousand', 2 => 'hundred'}


def numbers_in_words(number)
  if NUMBER_WORDS.keys.include?(number)
    return NUMBER_WORDS[number]
  elsif number < 100
    tens_place, ones_place = number.divmod(10)
    return NUMBER_WORDS[tens_place * 10] + " " + NUMBER_WORDS[ones_place]
  else
    POWERS_OF_TEN.each do |power, word|
      leading_digits, trailing_digits = number.divmod(10**power)
      if leading_digits > 0
        return numbers_in_words(leading_digits) + " " + word + " " + numbers_in_words(trailing_digits)
      end
    end
  end

end

# TEST DRIVE
p numbers_in_words(0) == ""
p numbers_in_words(10) == "ten"
p numbers_in_words(23) == "twenty three"
p numbers_in_words(973) == "nine hundred seventy three"
p numbers_in_words(1697) == "one thousand six hundred ninety seven"
p numbers_in_words(309728) == "three hundred nine thousand seven hundred twenty eight"
p numbers_in_words(930972012923912) == "nine hundred thirty trillion nine hundred seventy two billion twelve million nine hundred twenty three thousand nine hundred twelve"

