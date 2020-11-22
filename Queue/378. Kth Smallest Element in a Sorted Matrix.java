class MyHeapNode{
    int val;
    int row;int col;
    MyHeapNode(int val,int row, int col){
        this.val =val;
        this.row=row;
        this.col=col;
    }
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
     
        int n = matrix.length;
        
        //define a heap with capacity of min(k, n)
        PriorityQueue<MyHeapNode> heap=new PriorityQueue<MyHeapNode>(Math.min(n,k), new Comparator<MyHeapNode>(){
            public int compare(MyHeapNode n1, MyHeapNode n2){
                return n1.val-n2.val;
            }
        });
        
        //add all rows from first col to heap
        for(int i=0;i<Math.min(n,k);i++){
            heap.add(new MyHeapNode(matrix[i][0],i,0 ));
        }
        
        MyHeapNode node= heap.peek();
        while(k-->0){
            node  = heap.poll();
            
            int r= node.row;
            int c  =node.col;
            //if their are more elements in cur row then add those in heap
            if(c<n-1)
                heap.add(new MyHeapNode(matrix[r][c+1],r,c+1));
            
        }
        return node.val;
    }
}
