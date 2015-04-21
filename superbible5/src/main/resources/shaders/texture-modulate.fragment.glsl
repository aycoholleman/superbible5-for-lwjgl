#version 430 core

in vec2 vTex;

uniform sampler2D textureUnit0;
uniform vec4 vColor;

void main(void)
{
	gl_FragColor = vColor * texture2D(textureUnit0, vTex);
}
