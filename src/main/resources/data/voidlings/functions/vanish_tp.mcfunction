execute as @a[tag=voidlings.vanish] at @s run playsound minecraft:entity.breeze.wind_burst player @a ~ ~ ~ 10 0.5
execute as @a[tag=voidlings.vanish] at @s run spreadplayers ~ ~ 64 64 false @s[tag=voidlings.vanish]
execute as @a[tag=voidlings.vanish] at @s if block ~ ~-1 ~ minecraft:bedrock run spreadplayers ~ ~ 64 64 under 63 false @s[tag=voidlings.vanish]
tag @a[tag=voidlings.vanish] remove voidlings.vanish