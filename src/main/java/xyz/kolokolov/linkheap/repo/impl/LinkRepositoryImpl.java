package xyz.kolokolov.linkheap.repo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import xyz.kolokolov.linkheap.model.Link;
import xyz.kolokolov.linkheap.repo.LinkRepository;
import xyz.kolokolov.linkheap.repo.mapper.LinkListMapper;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class LinkRepositoryImpl extends JdbcDaoSupport implements LinkRepository {

    @Autowired
    public LinkRepositoryImpl(DataSource dataSource) {
        super();
        this.setDataSource(dataSource);
    }

    @Override
    public List<Link> getAllByChannel(String channelName) {
        String sql = "SELECT link.* " +
                "FROM link, channel " +
                "WHERE channel.name=? AND link.channel_id=channel.id";

        Object[] params = {channelName};

        return getJdbcTemplate().query(
                sql,
                params,
                new LinkListMapper());
    }

    @Override
    public Link add(String channel, Link link) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO link (channel_id, name, url, description)" +
                "VALUES (" +
                "(SELECT id FROM channel where channel.name=?)" +
                ",?,?,?)";

        getJdbcTemplate().update(con -> {
                    PreparedStatement statement = con.prepareStatement(sql, new String[]{"id"});
                    statement.setString(1, channel);
                    statement.setString(2, link.getTitle());
                    statement.setString(3, link.getUrl());
                    statement.setString(4, link.getDescription());
                    return statement;
                }, keyHolder
        );
        Number key = keyHolder.getKey();
        int id = key.intValue();
        link.setId(id);
        return link;
    }
}
