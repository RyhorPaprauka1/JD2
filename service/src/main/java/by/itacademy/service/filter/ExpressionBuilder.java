package by.itacademy.service.filter;

import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.function.Function;

@Getter
@NoArgsConstructor
public class ExpressionBuilder {

    private BooleanExpression expression;

    public <V> void add(V value, Function<V, BooleanExpression> function) {
        if (Objects.nonNull(value)) {
            if (Objects.isNull(expression)) {
                expression = function.apply(value);
            } else {
                expression.and(function.apply(value));
            }
        }
    }
}
