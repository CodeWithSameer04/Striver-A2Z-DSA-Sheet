class Solution {
    public void sortStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }

        int top = st.pop();          // remove top element
        sortStack(st);               // sort remaining stack
        insertSorted(st, top);       // insert back correctly
    }

    private void insertSorted(Stack<Integer> st, int value) {
        if (st.isEmpty() || st.peek() <= value) {
            st.push(value);
            return;
        }

        int top = st.pop();
        insertSorted(st, value);
        st.push(top);
    }
}
