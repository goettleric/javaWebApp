/**
 * 
 */
package edu.cvtc.web.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import edu.cvtc.web.model.Movie;

/**
 * @author Eric Goettl
 *
 */
public class MovieUtility {
	
	public static final String INPUT_FILE = "assets/Movies.xlsx";
	public static List<Movie> retrieveMoviesFromFile(final File inputFile) throws InvalidFormatException, IOException {
		
		final List<Movie> movies = new ArrayList<>();
		final Workbook movieList = WorkbookFactory.create(inputFile);
		final Sheet sheet = movieList.getSheetAt(0);
		
		for(final Row row: sheet){
			final Cell titleCell = row.getCell(0);
			final Cell releaseDateCell = row.getCell(1);
			final Cell lengthInMinutesCell = row.getCell(2);
			final Cell genreCell = row.getCell(3);
			final Cell leadActorCell = row.getCell(4);
			final Cell directorCell = row.getCell(5);
			final Cell pictureLinkCell = row.getCell(6);
			
			final Movie movie = new Movie(
					titleCell.getStringCellValue().trim(),
					releaseDateCell.getDateCellValue().toString().trim(),
					(int)lengthInMinutesCell.getNumericCellValue(),
					genreCell.getStringCellValue().trim(),
					leadActorCell.getStringCellValue().trim(),
					directorCell.getStringCellValue().trim(),
					pictureLinkCell.getStringCellValue());
			
			movies.add(movie);
		}
		return movies;
	}
}
