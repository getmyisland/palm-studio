# palm-studio

Palm Studio is a small Netflix clone I made that detects locally installed movies and series and displays them. It is really important that every movie file and every series/episode file is named accordingly.

## Movie

You have to configure the movies folder inside the of settings panel. It doesn't matter where your movies are located inside the movie folder as long as the files are named correctly.

This is an example of how a file could be named:
The_Evil_Dead_1983	or	The Evil Dead 1983

The last 4 letters are always the release year of the movie. The space/underscore between the release year and the name is important.

You can even use movie covers. In order to do this just place a .jpg image file with the same name as the movie in the same folder as the movie. In this case the image file would be named (The_Evil_Dead_1983.jpg)

This is how your file structure for the movie folder could look like. You should create a seperate folder just for the movies in order to get the best results.

Movies/The_Evil_Dead_1983
Movies/Army_of_Darkness_1993
Movies/More_Movies/The_Meg_2018

## Series

The Series folder structure is very important. It is also very important how Series folders and Episode files are named.

This is an example how a series folder could be named:
Game_Of_Thrones_20112019	or	Game Of Thrones 20112019

Just like movie covers you can have series covers. In order for it to work you have to place an image file inside of the series folder with the same name as the series folder. In this example it would be named like this: Game_Of_Thrones_20112019.jpg

Like the movies the last letters are always the release year. The special part about series is that they need a start year and an end year. The first episode of "Game of Thrones" was released in 2011 and the last episode in 2019.
The first number is the start year and the second number is the end year. If the series was just released you have to put the same year twice in a row.

### Episodes

Every episode should be inside the specific series folder.

This is an example of how a episode file could be named:
S01E01_Winter_is_Coming		or	S01E01 Winter is Coming

The first number is the season in which the episode appears and the second number the episode number.

This is how your series folder structure should look like, otherwise it may not work:

Series/Game_of_Thrones_20112019/S01E01_Winter_is_Coming
Series/Game_of_Thrones_20112019/S01E02_The_Kingsroad
Series/Game_of_Thrones_20112019/S03E02_Dark_Wings_Dark_Words

Series/Peacemaker_20222022/S01E01_A_Whole_New_Whirled
Series/Peacemaker_20222022/S01E02_Best_Friend_for_Never

## Summary

This program allows you to have your own version of Netflix. You can use it for personal videos, movies, series. The program even allows you to configure covers for movies or series.
