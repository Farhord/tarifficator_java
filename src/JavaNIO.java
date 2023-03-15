import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;

public class JavaNIO {

    public void tryNio() throws IOException {

        File testFile;
        testFile = File.createTempFile("testFile", ".txt");
        System.out.println("\nTemp file created: " + testFile.getAbsolutePath());

        String str = "Some data in file";
        byte[] bs = str.getBytes();
        Path writtenFilePath = Files.write(testFile.getAbsoluteFile().toPath(), bs);
        System.out.print("Written content: " + new String(Files.readAllBytes(writtenFilePath)));

        RandomAccessFile aFile = new RandomAccessFile(testFile, "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(10);
        int bytesRead = inChannel.read(buf);

        while (bytesRead != -1) {
            System.out.print("\nRead " + bytesRead + " bytes. Read string is: ");
            buf.flip();
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
        Files.delete(testFile.getAbsoluteFile().toPath());
        System.out.println("\nFile deleted");
    }
}
