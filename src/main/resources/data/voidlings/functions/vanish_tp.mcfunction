execute as @a[tag=voidlings.vanish] at @s run playsound minecraft:entity.breeze.wind_burst player @a ~ ~ ~ 10 0.5
execute as @a[tag=voidlings.vanish] at @s run spreadplayers ~ ~ 32 32 false @s[tag=voidlings.vanish]
tag @a[tag=voidlings.vanish] remove voidlings.vanish