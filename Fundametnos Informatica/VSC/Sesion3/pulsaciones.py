pulse_rest = int(input("How many beats per minute do you have at rest? ")) # Input: "60"
pulse_activity = int(input("How many beats per minute do you have after the first activity? "))# Input: "80"

puse_range = pulse_activity - pulse_rest # Value: 20
print(f"Your heart rate range is {puse_range} beats per minute")# Look at how we use the f before the strinng to allow interpolation

pulse_activity = int(input("How many beats per minute do you have after the second activity? "))# Input: "90"
puse_range = pulse_activity - pulse_rest # Value: 20
print(f"Your heart rate range is {puse_range} beats per minute")# Look at how we use the f before the strinng to allow interpolation

