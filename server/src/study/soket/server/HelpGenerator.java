package study.soket.server;

import study.socket.common.Message;

public class HelpGenerator implements MessageGenerator{
    @Override
    public Message generate(Server server) {
        server.setCount(server.getCount()+1);
        return new Message("""
                ������ ����� ������������ ��������� �������:
                /help - ������ ��������� �������� � �� ��������
                /ping - ����� ������ �������
                /requests - ���������� ������� ������������ ��������
                /popular - �������� ������ ����������� �������
                """);
    }
}
