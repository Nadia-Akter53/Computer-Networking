import java.util.Random;

public class NewClass {
    public static void main(String[] args) {
        int totalFrames = 10;  // Example input (adjust as needed)
        int windowSize = 4;
        int sent = 0, acked = 0;
        Random rand = new Random();

        while (acked < totalFrames) {
            // Ensure we don't exceed totalFrames
            int remainingFrames = totalFrames - sent;
            if (remainingFrames <= 0) break;  // Exit if all frames sent

            int framesToSend = Math.min(windowSize, remainingFrames);
            System.out.println("Sending frames: " + (sent + 1) + " to " + (sent + framesToSend));

            // Simulate ACKs (ensure at least 1 frame is ACKed)
            int ackCount = rand.nextInt(framesToSend) + 1;  // +1 to avoid 0
            acked += ackCount;
            sent += framesToSend;

            System.out.println("ACK received up to frame " + acked);
        }
        System.out.println("All frames transmitted!");
    }
}
