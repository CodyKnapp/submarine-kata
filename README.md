# Submarine Navigation Kata
## Philosophy
I opted to go with an approach here of having a submarine that maintained state to represent where it was as well 
as having methods to navigate. The possible directions were added to an enum to make processing and navigation obvious.
There is also a processor that simply takes a file and processes it line by line passing instructions to the Submarine.
This is used by the main to process the file after the args have been validated and the file opened.

The separation of components was done to allow simple testing without integrating too many features together.

Note: The current implementation can only go forward, up, and down. The file did not contain backward or any other directions,
so I left those concepts out of the solution to keep it simple. 

## Build
The gradle wrapper is included with the project so building is as simple as `./gradlew build`

## Run
Gradle again helps here, but it is less simple as the program does require command line arguments to run properly.
The input file must be specified as the only command line argument.

`./gradlew run --args="input_file_name.txt"`

In the case of the kata to be submitted, the input file name is `submarine_kata_input.txt`

`./gradlew run --args="submarine_kata_input.txt"`