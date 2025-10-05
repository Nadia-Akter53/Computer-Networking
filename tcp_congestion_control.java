public class TCP_Congestion {
    public static void main(String[] args) {
        int totalPackets = 20;
        int cwnd = 1;
        int ssthresh = 8;
        int sent = 0;

        while (sent < totalPackets) {
            System.out.println("[Phase: " + (cwnd < ssthresh ? "Slow Start" : "Avoidance") + "]");
            System.out.println("Window size: " + cwnd);

            // Send packets in current window
            for (int i = 0; i < cwnd && sent < totalPackets; i++) {
                System.out.println("Packet " + (sent + 1) + " sent.");
                sent++;
            }

            // Random loss (20% chance)
            if (Math.random() < 0.2) {
                System.out.println("--- Packet lost! Resetting cwnd. ---");
                ssthresh = cwnd / 2;
                cwnd = 1;
            } else {
                // Update cwnd
                if (cwnd < ssthresh) cwnd *= 2;
                else cwnd++;
            }
        }
        System.out.println("Transmission complete!");
    }
}
