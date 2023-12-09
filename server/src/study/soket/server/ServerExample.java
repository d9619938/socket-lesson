package study.soket.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
    public void exampleVoid() {
        ServerSocket serverSocket = null; // �������� ���������� ����������
        // � ����������� �����������
        OutputStream output = null; // �������� ���������� ������
        InputStream input = null; // �������� �������� ������


        try {
            serverSocket = new ServerSocket(2222); // �������� ��������� ��������� � ���������� �����.
            // ServerSocket ������� ��������� ����...
            System.out.println("������ �������");

            while (true) {
                Socket socket = serverSocket.accept(); // ...� ������������� ���������� ��� ��������� �������
                System.out.println("����� �����������");

                System.out.println(socket.getLocalSocketAddress());
                System.out.println(socket.getRemoteSocketAddress());

                output = socket.getOutputStream(); // ��� �������� ������ �� socket ����������
                input = socket.getInputStream(); // ��� ��������� ������ �� socket ����������

                // ObjectInputStream objectInput = new ObjectInputStream(input); // ��������������
                // ObjectOutputStream objectOutput = new ObjectOutputStream(output); // ������������

                // ��������, ����� � inputStream �������� ������
                System.out.println(input.read()); // ������ ������ �� inputStream
                output.write(2); // �������� ������ � outputStream
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (input != null) input.close();
                if (output != null) output.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
