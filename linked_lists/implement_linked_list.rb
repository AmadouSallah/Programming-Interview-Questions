class Node
  attr_accessor :value, :next_node
  def initialize(value, next_node = nil)
    @value = value
    @next_node = next_node
  end
end

class List
  attr_accessor :head
  def initialize(head)
    @head = head
  end

  # Defining an each method for looping through each node
  def each
    node = @head
    while node
      yield node
      node = node.next_node
    end
  end

  # Finds and returns the 1st node whose value is 'value'
  def find(value)
    self.each {|node| return node if node.value == value}
  end

  # find_all(value) finds and return (in an array) all the nodes whose value is 'value'
  def find_all(value)
    nodes = []
    self.each {|node| nodes << node if node.value == value}
    nodes
  end

  # push(value) adds a value 'value' to the end of the linked list
  def push(value)
    last.next_node = Node.new(value, nil)
  end

  # Adds a node of value 'value' at the beginning of the linked list
  def unshift(value)
    @head = Node.new(value, @head)
  end

  # Returns the last element of the linked list
  def last
    self.each {|node| return node if node.next_node == nil}
  end

  # Returns the length of the linked list
  def length
    count = 0
    node = @head
    while node
      count += 1
      node = node.next_node
    end
    count
  end

end

# TEST DRIVE
# e = Node.new(5, nil)
# d = Node.new(4, e)
# c = Node.new(3, d)
# b = Node.new(3, c)
# a = Node.new(1, b)

# list = List.new(a)

# print "The values of the list are: "
# list.each {|node| print node.value, " "}

# puts "\nThe first node with value 3 is:"
# p list.find(3)

# puts "\nThe nodes whose value is 3 are: "
# p list.find_all(3)

# puts "\nAdding a node with value 6 to the end of the linked list:"
# list.push(6)
# print "The values of the list are now: "
# list.each {|node| print node.value, " "}

# puts "\nThe last node is:"
# p list.last

# puts "\nAdding a node of value 0 at the beginning of the linked list:"
# list.unshift(0)
# print "The values of the list are now: "
# list.each {|node| print node.value, " "}

# puts "\n\nThe length of the linked list currently is #{list.length}"
# last_node_list = List.new(list.last)
# p last_node_list.length
# p List.new(nil).length