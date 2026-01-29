class Solution {
    public void reverseStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }

        int top = st.pop();
        reverseStack(st);
        insertAtBottom(st, top);
    }

    private void insertAtBottom(Stack<Integer> st, int value) {
        if (st.isEmpty()) {
            st.push(value);
            return;
        }

        int top = st.pop();
        insertAtBottom(st, value);
        st.push(top);
    }
}
