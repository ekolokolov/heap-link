package xyz.kolokolov.linkheap.repo;

import xyz.kolokolov.linkheap.model.Link;

import java.util.List;

public interface LinkRepository {

    List<Link> getAllByChannel(String channelName);

    Link add(String channel, Link link);
}
