package Greedy;
public class Main_Test {
    public static void main(String[] args) {
        generateHardTest(100, 100);
    }

    /**
     * 가능한 한 많은 BFS 방문을 유도하고,
     * 어떤 삼중합도 맨 아랫행에 도달 못 하도록 만드는
     * 100×100 테스트케이스를 생성하여 표준 출력으로 내보낸다.
     */
    public static void generateHardTest(int N, int M) {
        // 첫 줄: N M 출력
        System.out.println(N + " " + M);
        
        // 0번 행(첫 행): [0,0,...(10번), 1,1,...(10번), ..., 9,9,...(10번)] 총 100개
        // 각 숫자마다 10개씩 연속해서 배치
        StringBuilder row0Builder = new StringBuilder();
        for (int digit = 0; digit < 10; digit++) {
            for (int count = 0; count < 10; count++) {
                row0Builder.append(digit);
                if (!(digit == 9 && count == 9)) { 
                    // 마지막 숫자가 아니면 사이에 공백 추가
                    row0Builder.append(" ");
                }
            }
        }
        System.out.println(row0Builder.toString());
        
        // 1번 행부터 99번 행: i번째 행은 (i mod 10) 숫자 100개
        // 예) 1번 행은 전부 '1', 2번 행 전부 '2', ... , 10번 행 전부 '0', 11번 행 전부 '1', ...
        for (int i = 1; i < M; i++) {
            int digit = i % 10;
            StringBuilder rowBuilder = new StringBuilder();
            for (int col = 0; col < N; col++) {
                rowBuilder.append(digit);
                if (col < N - 1) {
                    rowBuilder.append(" ");
                }
            }
            System.out.println(rowBuilder.toString());
        }
    }
}
