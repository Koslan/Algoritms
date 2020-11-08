public class FindPoint {
    public static void main(String[] args) {

        double rtx3080 = 1;
        double oldCPU = 1;

        int rtxCores = 8704;
        int oldCpuCores = 1;

        for(int i = 30_000_000; i < 440_000_000; i++) {
            rtx3080 =  (4 * 1 * i) / rtxCores;
            rtx3080 /=  1_000_000_000;

            oldCPU = (double) (7 * 8 * (int)(Math.log(i) / Math.log(2))) / (double) (1 * 1_000_000 * oldCpuCores);

            if( i % 1_000_000 == 0) {
                System.out.println("value \n" + i);
                System.out.println("rtx3080 \n" + rtx3080);
                System.out.println("oldCPU \n" + oldCPU);
            }

            if(oldCPU < rtx3080) {
                System.out.println("value \n" + i);
                System.out.println("rtx3080 \n" + rtx3080);
                System.out.println("oldCPU \n" + oldCPU);
                break;
            }

        }
    }
}
