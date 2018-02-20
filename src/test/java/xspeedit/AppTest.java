package xspeedit;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import xspeedit.domain.Crate;

@RunWith(BlockJUnit4ClassRunner.class)
public class AppTest {

    @Test
    public void testFirstFitDecreasing() {
	
	List<Crate> result = App.arrangeCrates(Arrays.asList(1,6,3,8,4,1,6,8,9,5,2,5,7,7,3));
	
	Assert.assertNotNull(result);
    }
}
