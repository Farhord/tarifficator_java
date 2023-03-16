import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JavaNIO {

    public List<String> tryNio() throws IOException {

        List<String> list = new ArrayList<>();
        String message;

        File testFile;
        testFile = File.createTempFile("testFile", ".txt");
        message = "Temp file created: " + testFile.getAbsolutePath();
        System.out.println("\n" + message);
        list.add(message);

        String str = "Some data in file";
        byte[] bs = str.getBytes();
        Path writtenFilePath = Files.write(testFile.getAbsoluteFile().toPath(), bs);
        message = "Written content: " + new String(Files.readAllBytes(writtenFilePath));
        System.out.print(message);
        list.add(message);

        RandomAccessFile aFile = new RandomAccessFile(testFile, "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(10);
        int bytesRead = inChannel.read(buf);

        while (bytesRead != -1) {
            message = "Read " + bytesRead + " bytes. Read string is: ";
            System.out.print("\n" + message);
            list.add(message);
            buf.flip();
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
        Files.delete(testFile.getAbsoluteFile().toPath());
        message = "File deleted";
        System.out.println("\n" + message);
        list.add(message);

        return list;
    }
}
