class MedianFinder {

    PriorityQueue<Integer> smallerHalf; // one more than larger half, or equal to larger half
    PriorityQueue<Integer> largerHalf;

    /** initialize your data structure here. */
    public MedianFinder() {
        smallerHalf = new PriorityQueue<Integer>(new MaxComparator());
        largerHalf = new PriorityQueue<Integer>(new MinComparator());
    }

    // below addNum() with too many condition checks
    // @note: simple logic: always add to larger half, and if larger half 1 more than smaller half, then re-balance

    public void addNum(int num) {
        // 2 polls() and 3 offer(), total 5 operations, each logN => 5 * logN ~= logN
        // https://stackoverflow.com/questions/28819327/time-complexity-of-inserting-in-to-a-heap

        // always to smaller half first
        // can check if num bigger than smallerHalf.peek, to directly offer to biggerHalf
        smallerHalf.offer(num);

        // now smaller half get additional int, re-balance by smaller half giving its max to smaller half
        largerHalf.offer(smallerHalf.poll());

        if (smallerHalf.size() < largerHalf.size()) { // only for the 1st time initial num being added
            smallerHalf.offer(largerHalf.poll());
        }
    }

    public double findMedian() {
        if (smallerHalf.size() == largerHalf.size()) {
            return (smallerHalf.peek() + largerHalf.peek()) / 2.0; // @note: double division
        } else { // smaller half is one more
            return smallerHalf.peek();
        }
    }


    class MaxComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1; //max first
        }
    }

    class MinComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2; // min first
        }

    }
}


class MedianFinder_NlogN {

    List<Integer> list;

    /** initialize your data structure here. */
    public MedianFinder_NlogN() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
        Collections.sort(list); // maintain a sorted list
    }

    public double findMedian() {

        int length = list.size();

        if (length % 2 == 1) {
            return list.get(length / 2);
        } else {
            return (list.get(length / 2) + list.get(length / 2 -1)) / 2.0; // @note: if x / 2, then will be an int, 3/2==1, 3/2.0==1.5
        }
    }
}
