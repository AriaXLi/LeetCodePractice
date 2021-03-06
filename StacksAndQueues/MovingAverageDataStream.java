// Problem: Moving Average from Data Stream
// Difficulty: Easy
// https://leetcode.com/problems/moving-average-from-data-stream/

	class MovingAverageDataStream {
  int size, head, windowSum, count = 0;
  int[] queue;
  public MovingAverage(int size) {
    this.size = size;
    queue = new int[size];
  }

  public double next(int val) {
    ++count;
    
    // calculate the new sum by shifting the window
    int tail = (head + 1) % size;
    windowSum = windowSum - queue[tail] + val;
    
    // move on to the next head
    head = (head + 1) % size;
    queue[head] = val;
    return windowSum * 1.0 / Math.min(size, count);
  }
}