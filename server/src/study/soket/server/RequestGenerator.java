package study.soket.server;

import study.socket.common.Message;

public class RequestGenerator implements MessageGenerator{
    @Override
    public Message generate(Server server) {

        return new Message("���������� ������� ������������ �������� �������� - "
                + server.getCount());
    }
}
