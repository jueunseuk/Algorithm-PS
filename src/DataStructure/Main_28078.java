package DataStructure;
import java.io.*;
import java.util.*;

public class Main_28078 {
    static class Node {
        char c;   // 'b' or 'w'
        int count;
        Node(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    static class FastReader {
        BufferedInputStream bis;
        byte[] buf = new byte[1<<16];
        int curChar, numChars;
        
        FastReader() {
            bis = new BufferedInputStream(System.in);
        }
        
        int read() throws IOException {
            if (numChars == -1) return -1;
            if (curChar >= numChars) {
                curChar = 0;
                numChars = bis.read(buf);
                if (numChars == -1) return -1;
            }
            return buf[curChar++];
        }
        
        int nextInt() throws IOException {
            int c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            int res = 0;
            do {
                res = res * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -res : res;
        }

        String nextWord() throws IOException {
            int c = read();
            while (c <= ' ') c = read();
            StringBuilder sb = new StringBuilder();
            do {
                sb.append((char) c);
                c = read();
            } while (c > ' ');
            return sb.toString();
        }
    }

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();

        int n = fr.nextInt();
        int direction = 1;
        int ballCnt = 0;
        int wallCnt = 0;

        Deque<Node> deq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String order = fr.nextWord();
            switch (order) {
                case "push": {
                    String param = fr.nextWord();
                    boolean canPush = false;
                    if (direction == 1 || direction == 3) {
                        canPush = true;
                    } else if (direction == 2) {
                        if (!deq.isEmpty()) {
                            canPush = true;
                        } else {
                            // 덱이 비었을 때 push "w"만 가능
                            if (param.equals("w")) canPush = true;
                        }
                    } else if (direction == 4) {
                        // 북쪽일 때 "w"만 push 가능
                        if (param.equals("w")) canPush = true;
                    }

                    if (canPush) {
                        if (!deq.isEmpty() && deq.peekLast().c == param.charAt(0)) {
                            deq.peekLast().count++;
                        } else {
                            deq.addLast(new Node(param.charAt(0), 1));
                        }
                        if (param.equals("b")) ballCnt++;
                        else wallCnt++;
                    }
                    break;
                }
                case "pop": {
                    if (!deq.isEmpty()) {
                        if (direction == 1 || direction == 3 || direction == 4) {
                            Node front = deq.peekFirst();
                            front.count--;
                            if (front.c == 'b') {
                                ballCnt--;
                            } else {
                                wallCnt--;
                            }
                            if (front.count == 0) {
                                deq.pollFirst();
                            }
                        } else {
                            // direction == 2
                            Node front = deq.peekFirst();
                            if (front.c == 'w') {
                                front.count--;
                                wallCnt--;
                                if (front.count == 0) {
                                    deq.pollFirst();
                                }
                                while (!deq.isEmpty() && deq.peekFirst().c == 'b') {
                                    Node bNode = deq.pollFirst();
                                    ballCnt -= bNode.count;
                                }
                            }
                        }
                    }
                    break;
                }
                case "rotate": {
                    String param = fr.nextWord();
                    if (param.equals("l")) {
                        direction--;
                        if (direction == 0) direction = 4;
                    } else {
                        direction++;
                        if (direction == 5) direction = 1;
                    }

                    if (direction == 2) {
                        while (!deq.isEmpty() && deq.peekFirst().c == 'b') {
                            Node front = deq.pollFirst();
                            ballCnt -= front.count;
                        }
                    } else if (direction == 4) {
                        while (!deq.isEmpty() && deq.peekLast().c == 'b') {
                            Node last = deq.pollLast();
                            ballCnt -= last.count;
                        }
                    }
                    break;
                }
                case "count": {
                    String param = fr.nextWord();
                    if (param.equals("b")) {
                        sb.append(ballCnt).append('\n');
                    } else {
                        sb.append(wallCnt).append('\n');
                    }
                    break;
                }
            }
        }

        System.out.print(sb.toString());
    }
}
