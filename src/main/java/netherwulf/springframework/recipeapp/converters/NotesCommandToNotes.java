package netherwulf.springframework.recipeapp.converters;

import lombok.Synchronized;
import netherwulf.springframework.recipeapp.commands.NotesCommand;
import netherwulf.springframework.recipeapp.domain.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesCommand source) {
        if (source == null) {
            return null;
        }

        final Notes notes = new Notes();
        notes.setId(String.valueOf(source.getId()));
        notes.setRecipeNotes(source.getRecipeNotes());
        return notes;
    }
}
