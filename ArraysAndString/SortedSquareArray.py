# Link: https://www.algoexpert.io/questions/Sorted%20Squared%20Array
# Difficulty: Easy
# Time complexity: O(n)
# Space complexity: O(n)

def sortedSquaredArray(array):
    # Write your code here.
    for i in range(len(array)):
        array[i] = array[i] * array[i]
    array.sort()	
    return array