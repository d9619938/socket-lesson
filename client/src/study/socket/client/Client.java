package study.socket.client;

import study.socket.common.ConnectionService;
import study.socket.common.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
    private InetSocketAddress remoteAddress;

    /*2. ������:
2.1. ����������� ����� ��������� (������) � ������������
2.2. ������������� ���������� � ��������
2.3. ������� ��������� ���������
2.4. ���������� ��������� �� ������
2.5. �������� �����
2.6. ������� ���������� ����� � �������
2.7. ��������� ���������� � ��������
� ��� �� ��� ���, ���� ������������ �� ������ '/exit'*/

    public Client(InetSocketAddress remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
                System.out.println("������� ����� ��� /exit");
                String text = scanner.nextLine();
                if (text.equals("/exit")) break;

                try (Socket socket = new Socket()) {
                    socket.connect(remoteAddress);
                    try (ConnectionService service = new ConnectionService(socket)) {
                        service.writeMessage(new Message(text));

                        Message message = service.readMessage();
                        System.out.println(message);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                        System.out.println("������ �������� ��������");
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    System.out.println("������ �� ��������");
                }



        }

    }
}
