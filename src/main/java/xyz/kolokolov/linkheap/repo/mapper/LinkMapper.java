package xyz.kolokolov.linkheap.repo.mapper;

import org.springframework.jdbc.core.RowMapper;
import xyz.kolokolov.linkheap.model.Link;

import java.sql.ResultSet;
import java.sql.SQLException;


public class LinkMapper implements RowMapper<Link> {
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String URL = "url";
    private static final String DESCRIPTION = "description";

    @Override
    public Link mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Link(rs.getInt(ID), rs.getString(NAME), rs.getString(URL), rs.getString(DESCRIPTION));
    }
}
