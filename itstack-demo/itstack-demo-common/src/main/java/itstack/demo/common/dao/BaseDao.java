package itstack.demo.common.dao;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: fuzhengwei1
 * Date: 16-3-1
 * Time: 下午5:14
 * To change this template use File | Settings | File Templates.
 */
public class BaseDao extends SqlMapClientTemplate {

    public List queryForListMerge(String statementName, String getFieldName, String setFieldname, String mergeFieldKeyName, String mergeStatementName) throws DataAccessException {
        return queryForListMerge(statementName, null, getFieldName, setFieldname, mergeFieldKeyName, mergeStatementName);
    }



    public List queryForListMerge(String statementName, Object parameterObject, String getFieldName, String setFieldname, String mergeFieldKeyName, String mergeStatementName) throws DataAccessException {
        List list = queryForList(statementName, parameterObject); //��ѯ�Ӽ���
        merge(list, getFieldName, setFieldname, mergeFieldKeyName, mergeStatementName);

        return list;
    }


    public void merge(List list, String getFieldName, String setFieldname, String mergeFieldKeyName, String mergeStatementName) {
        Set<String> values = new HashSet<String>();
        try {

            for (Object o : list) {
                String property = BeanUtils.getProperty(o, getFieldName);
                if (!StringUtils.isEmpty(property)) {
                    values.add(property);
                }
            }

            if (!values.isEmpty()) {
                StringBuilder builder = new StringBuilder();

                for (String value : values) {
                    builder.append(',');
                    builder.append(value);
                }

                List merges = queryForList(mergeStatementName, builder.substring(1));
                for (Object obj : list) {
                    String val = BeanUtils.getProperty(obj, getFieldName);

                    if (!StringUtils.isEmpty(val)) {
                        for (Object merge : merges) {
                            if (val.equals(BeanUtils.getProperty(merge, mergeFieldKeyName))) {
                                BeanUtils.setProperty(obj, setFieldname, merge);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("merge error!", e);
        }
    }
}
