package Chapter1;

/**
 * @author ayaph
 *
 */
public class SeasonTest {

	public static void main(String[] args) {
		Season season = Season.SUMMER;
		Season season2 = Season.SUMMER;
		System.out.println(Season.SUMMER);
		System.out.println(season == Season.SUMMER);

		System.out.println(season);
		switch (season)
		{
			case WINTER: 
				System.out.println("Get out the sled"); 
				break;
			case SUMMER:
				System.out.println("Time for the pool"); 
				break;
			default:
				System.out.println("Is it summer yet?");
		}
		season.printExpectedVisitors();
		season.printHours();
		season.printExtendedHours();
	}

}
