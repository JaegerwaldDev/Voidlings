effect give @s minecraft:invisibility 30 0 true
tag @s add voidlings.vanish
# execute at @a[tag=voidlings.vanish] run particle farmersdelight:steam ~ ~ ~ 0 0 0 .5 1000 force
schedule function voidlings:vanish_tp 2t replace