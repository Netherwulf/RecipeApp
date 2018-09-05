package netherwulf.springframework.recipeapp.services;

import netherwulf.springframework.recipeapp.domain.Recipe;
import netherwulf.springframework.recipeapp.repositories.RecipeRepository;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ImageServiceImpl.class);
    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional
    public void saveImageFile(Long id, MultipartFile file) {

        try {

            Recipe recipe = recipeRepository.findById(String.valueOf(id)).get();

            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for(byte b : file.getBytes()){
                byteObjects[i++] = b;
            }

            recipe.setImage(byteObjects);

            recipeRepository.save(recipe);

        } catch(IOException e){

            //todo handle exception better

            log.error("IO error occured", e);

            e.printStackTrace();
        }

    }
}
