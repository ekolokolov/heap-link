package xyz.kolokolov.linkheap.repo.mapper;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import xyz.kolokolov.linkheap.model.Link;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LinkListMapper implements ResultSetExtractor<List<Link>> {

    @Override
    public List<Link> extractData(ResultSet rs) throws SQLException, DataAccessException {
        ArrayList<Link> links = new ArrayList<>();
        LinkMapper linkMapper = new LinkMapper();
        while (rs.next()) {
            links.add(linkMapper.mapRow(rs, rs.getRow()));
        }
        return links;
    }
}
